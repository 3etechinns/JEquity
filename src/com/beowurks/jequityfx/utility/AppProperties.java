/*
 * J'EquityFX
 * Copyright(c) 2008-2017
 * Original Author: Eddie Fann
 * License: Eclipse Public License
 *
 */
package com.beowurks.jequityfx.utility;

import com.beowurks.jequityfx.dao.combobox.IntegerKeyItem;
import com.beowurks.jequityfx.view.dialog.PasswordDialog;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;

// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
public final class AppProperties extends BaseProperties
{

  public static final AppProperties INSTANCE = new AppProperties();

  private boolean flSuccessfulRead = false;

  // Always have to start with the default password as the real one is never
  // saved to disk.
  private String fcPassword = AppProperties.getDefaultMasterKey();

  // -----------------------------------------------------------------------------
  private AppProperties()
  {
    super(Constants.LOCAL_PATH, Constants.USER_FILENAME, "J'Equity\u00a9 Parameters - DO NOT EDIT . . . please", AppProperties.getDefaultMasterKey(), false, false);

    // I'm not sure if this is the best strategy, a JDialog box inside of a constructor. However, in order to read
    // this particular property file, a password must be used. So, we'll try this for now.
    int lnPasswordAttempts = 0;
    while (!this.readProperties())
    {
      if (lnPasswordAttempts++ < 3)
      {
        final String lcPassword = this.requestMasterKey();
        if (lcPassword != null)
        {
          this.setMasterKey(lcPassword);
          continue;
        }
      }

      Misc.startShutdown();
      return;
    }

  }

  // ---------------------------------------------------------------------------
  @Override
  public boolean readProperties()
  {
    this.flSuccessfulRead = super.readProperties();

    return (this.flSuccessfulRead);
  }

  // ---------------------------------------------------------------------------
  @Override
  public boolean writeProperties()
  {
    if (this.flSuccessfulRead)
    {
      return (super.writeProperties());
    }

    return (false);
  }

  // ---------------------------------------------------------------------------
  public boolean isSuccessfullyRead()
  {
    return (this.flSuccessfulRead);
  }

  // -----------------------------------------------------------------------------
  public String requestMasterKey()
  {
    Misc.setStatusText("Requesting Master Key. . . .");

    final PasswordDialog loDialog = new PasswordDialog();
    loDialog.setTitle("Enter Master Password");

    final Optional<String> loResults = loDialog.showAndWait();
    if (loResults.isPresent())
    {
      return (loResults.get());
    }

    return (null);
  }

  // -----------------------------------------------------------------------------
  public IntegerKeyItem[] getRDBMS_Types()
  {
    return (Constants.RDBMS_DRIVERS);
  }

  // -----------------------------------------------------------------------------
  public IntegerKeyItem[] getDailyIntervals()
  {
    return (Constants.DAILY_INTERVAL);
  }

  // -----------------------------------------------------------------------------
  public IntegerKeyItem[] getDailyStarts()
  {
    return (Constants.DAILY_START);
  }

  // -----------------------------------------------------------------------------
  public String getDefaultDerbyUser()
  {
    return (Constants.DERBY_USERNAME);
  }

  // -----------------------------------------------------------------------------
  public String getDerbyBootPassword()
  {
    return (Constants.DERBY_BOOT_PASSWORD);
  }

  // -----------------------------------------------------------------------------
  public String getDefaultDerbyPassword()
  {
    return (Constants.DERBY_DEFAULT_PASSWORD);
  }

  // -----------------------------------------------------------------------------
  public int getDefaultDriverKey()
  {
    return (Constants.DRIVER_KEY_DERBY);
  }

  // -----------------------------------------------------------------------------
  public String getDefaultDatabase()
  {
    return (Constants.DERBY_PATH);
  }

  // -----------------------------------------------------------------------------
  public String getDefaultHost()
  {
    return ("localhost");
  }

  // -----------------------------------------------------------------------------
  public String getConnectionURL()
  {
    final StringBuilder lcURL = new StringBuilder();
    final int lnKey = this.getConnectionRDBMS_Key();

    switch (lnKey)
    {
      case Constants.DRIVER_KEY_DERBY:

        final String lcFolder = this.getConnectionDatabase();

        lcURL.append("jdbc:derby:" + lcFolder)
            .append(";upgrade=true")
            .append(";bootPassword=" + this.getDerbyBootPassword());

        final boolean llBrandNew = (!Files.isDirectory(Paths.get(lcFolder), LinkOption.NOFOLLOW_LINKS));
        if (!llBrandNew)
        {
          final File loFolder = new File(lcFolder);
          // Just in case it's an empty directory.
          final Collection<File> laFiles = FileUtils.listFilesAndDirs(loFolder, TrueFileFilter.INSTANCE, DirectoryFileFilter.DIRECTORY);
          // Will probably contain the lcFolder.
          if (laFiles.size() <= 1)
          {
            Misc.errorMessage(String.format("You must remove the empty folder of %s in order to continue.", lcFolder));
            return ("");
          }
        }

        if (llBrandNew)
        {
          lcURL.append(";create=true")
              .append(";dataEncryption=true");
        }
        break;

      case Constants.DRIVER_KEY_MYSQL5:
        lcURL.append("jdbc:mysql://" + this.getConnectionHost() + "/" + this.getConnectionDatabase());
        break;

      case Constants.DRIVER_KEY_POSTGRESQL91:
        lcURL.append("jdbc:postgresql://" + this.getConnectionHost() + "/" + this.getConnectionDatabase());
        break;
    }

    return (lcURL.toString());
  }

  // -----------------------------------------------------------------------------
  public String getConnectionDatabase()
  {
    return (this.getProperty(Constants.CONNECTION_DATABASE, Constants.DERBY_PATH).trim());
  }

  // -----------------------------------------------------------------------------
  public String getConnectionHost()
  {
    return (this.getProperty(Constants.CONNECTION_HOST, this.getDefaultHost()).trim());
  }

  // -----------------------------------------------------------------------------
  public String getConnectionUser()
  {
    return (this.getProperty(Constants.CONNECTION_USER, this.getDefaultDerbyUser()).trim());
  }

  // -----------------------------------------------------------------------------
  public String getConnectionPassword()
  {
    return (this.getProperty(Constants.CONNECTION_PASSWORD, this.getDefaultDerbyPassword()).trim());
  }

  // -----------------------------------------------------------------------------
  public int getConnectionRDBMS_Key()
  {
    return (this.getProperty(Constants.CONNECTION_RDBMS_KEY, Constants.RDBMS_DRIVERS[0].getKey()));
  }

  // -----------------------------------------------------------------------------
  public int getDailyIntervalKey()
  {
    // Default is every 10 minutes.
    return (this.getProperty(Constants.DAILY_INTERVAL_KEY, Constants.DAILY_INTERVAL[1].getKey()));
  }

  // -----------------------------------------------------------------------------
  public int getDailyStartKey()
  {
    return (this.getProperty(Constants.DAILY_START_KEY, Constants.DAILY_START[0].getKey()));
  }

  // -----------------------------------------------------------------------------
  public String getConnectionRDBMS_Description()
  {
    final int lnIndex = this.convertKeyToIndex(this.getRDBMS_Types(), this.getConnectionRDBMS_Key());

    return (Constants.RDBMS_DRIVERS[lnIndex].toString());
  }

  // -----------------------------------------------------------------------------
  public String getBackupRestoreFolder()
  {
    return (this.getProperty(Constants.BACKUP_RESTORE_FOLDER, Misc.includeTrailingBackslash(System.getProperty("user.home"))));
  }

  // -----------------------------------------------------------------------------
  public java.util.Date getHistoricalStartDefault()
  {
    final Calendar loCalendar = Calendar.getInstance();

    loCalendar.set(2014, 0, 1);
    final java.util.Date ldHistoricalStartDateDefault = loCalendar.getTime();

    return (this.getProperty(Constants.HISTORICAL_START_DEFAULT, ldHistoricalStartDateDefault));
  }

  // -----------------------------------------------------------------------------
  public java.util.Date getHistoricalStart(final String tcSymbol)
  {
    return (this.getProperty(Constants.HISTORICAL_START + tcSymbol, this.getHistoricalStartDefault()));
  }

  // -----------------------------------------------------------------------------
  public boolean getFlywayAlwaysCheck()
  {
    return (this.getProperty(Constants.FLYWAY_ALWAYS_CHECK, false));
  }

  // -----------------------------------------------------------------------------
  // This represents the version of J'Equity where Flyway was successful.
  public String getFlywaySuccessfulJEquityVersion()
  {
    return (this.getProperty(Constants.FLYWAY_SUCCESSFUL_JEQUITY, "0.0.0.0.0"));
  }

  // -----------------------------------------------------------------------------
  public String getExportFileChooserFilename()
  {
    return (this.getProperty(Constants.EXPORT_FILECHOOSER_FILENAME, "export.xls"));
  }

  // -----------------------------------------------------------------------------
  public boolean getExportFileChooserIncludeComments()
  {
    return (this.getProperty(Constants.EXPORT_FILECHOOSER_INCLUDE_COMMENTS, false));
  }

  // -----------------------------------------------------------------------------
  public int getExportFileChooserFilter()
  {
    return (this.getProperty(Constants.EXPORT_FILECHOOSER_FILTER, 0));
  }

  // -----------------------------------------------------------------------------
  private int getPositionOfFirstNumber(final String tcValue)
  {
    final int lnLength = tcValue.length();
    int lnPos = 0;
    while ((lnPos < lnLength) && !Character.isDigit(tcValue.charAt(lnPos)))
    {
      lnPos++;
    }

    return (lnPos);
  }

  // -----------------------------------------------------------------------------
  // -----------------------------------------------------------------------------
  public void setConnectionDatabase(final String tcValue)
  {
    this.setProperty(Constants.CONNECTION_DATABASE, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setConnectionHost(final String tcValue)
  {
    this.setProperty(Constants.CONNECTION_HOST, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setConnectionUser(final String tcValue)
  {
    this.setProperty(Constants.CONNECTION_USER, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setConnectionPassword(final String tcValue)
  {
    this.setProperty(Constants.CONNECTION_PASSWORD, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setConnectionRDBMS_Key(final int tnValue)
  {
    this.setProperty(Constants.CONNECTION_RDBMS_KEY, tnValue);
  }

  // -----------------------------------------------------------------------------
  public void setDailyIntervalKey(final int tnValue)
  {
    this.setProperty(Constants.DAILY_INTERVAL_KEY, tnValue);
  }

  // -----------------------------------------------------------------------------
  public void setDailyStartKey(final int tnValue)
  {
    this.setProperty(Constants.DAILY_START_KEY, tnValue);
  }

  // -----------------------------------------------------------------------------
  public void setBackupRestoreFolder(final String tcValue)
  {
    this.setProperty(Constants.BACKUP_RESTORE_FOLDER, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setHistoricalStartDefault(final java.util.Date tdValue)
  {
    this.setProperty(Constants.HISTORICAL_START_DEFAULT, tdValue);
  }

  // -----------------------------------------------------------------------------
  public void setHistoricalStart(final String tcSymbol, final java.util.Date tdValue)
  {
    this.setProperty(Constants.HISTORICAL_START + tcSymbol, tdValue);
  }

  // -----------------------------------------------------------------------------
  public void setFlywayAlwaysCheck(final boolean tlValue)
  {
    this.setProperty(Constants.FLYWAY_ALWAYS_CHECK, tlValue);
  }

  // -----------------------------------------------------------------------------
  // This represents the version of J'Equity where Flyway was successful.
  public void setFlywaySuccessfulJEquityVersion(final String tcValue)
  {
    this.setProperty(Constants.FLYWAY_SUCCESSFUL_JEQUITY, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setExportFileChooserFilename(final String tcValue)
  {
    this.setProperty(Constants.EXPORT_FILECHOOSER_FILENAME, tcValue);
  }

  // -----------------------------------------------------------------------------
  public void setExportFileChooserIncludeComments(final boolean tlValue)
  {
    this.setProperty(Constants.EXPORT_FILECHOOSER_INCLUDE_COMMENTS, tlValue);
  }

  // -----------------------------------------------------------------------------
  public void setExportFileChooserFilter(final int tnValue)
  {
    this.setProperty(Constants.EXPORT_FILECHOOSER_FILTER, tnValue);
  }

  // -----------------------------------------------------------------------------
  // -----------------------------------------------------------------------------
  public int convertIndexToKey(final IntegerKeyItem[] taItems, final int tnIndex)
  {
    int lnIndex = tnIndex;

    if (lnIndex < 0)
    {
      lnIndex = 0;
    }

    if (lnIndex >= taItems.length)
    {
      lnIndex = taItems.length - 1;
    }

    return (taItems[lnIndex].getKey());
  }

  // -----------------------------------------------------------------------------
  public int convertKeyToIndex(final IntegerKeyItem[] taItems, final int tnKey)
  {
    final int lnLength = taItems.length;

    int lnValue = 0;
    for (int i = 0; i < lnLength; ++i)
    {
      if (taItems[i].getKey() == tnKey)
      {
        lnValue = i;
        break;
      }
    }

    return (lnValue);
  }

  // -----------------------------------------------------------------------------
  // -----------------------------------------------------------------------------
  // Never save the password to the property's file.
  public void setMasterKey(final String tcValue)
  {
    this.fcPassword = tcValue;
    this.setKey(this.fcPassword);
  }

  // -----------------------------------------------------------------------------
  public static String getDefaultMasterKey()
  {
    final StringBuilder loBuilder = new StringBuilder(Constants.USER_FILENAME);

    return ("*" + loBuilder.reverse().append("*").toString());
  }

  // -----------------------------------------------------------------------------
}
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------