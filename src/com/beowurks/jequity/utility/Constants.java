/*
 * J'Equity
 * Copyright(c) 2008-2017
 * Original Author: Eddie Fann
 * License: Eclipse Public License
 *
 */
package com.beowurks.jequity.utility;

import com.beowurks.jequity.dao.combobox.IntegerKeyItem;
import com.beowurks.jequity.main.Main;


// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
final public class Constants
{

  public final static String SPLASH_SCREEN = "org/netbeans/core/startup/splash_jequity.gif";
  public final static int SPLASH_SCREEN_WIDTH = 256;
  public final static int SPLASH_SCREEN_HEIGHT = 256;

  public final static String TEMPORARY_PATH = Misc.includeTrailingBackslash(Misc.includeTrailingBackslash(Misc
      .includeTrailingBackslash(System.getProperty("java.io.tmpdir"))
      + "Beowurks") + "JEquity");

  public final static String LOCAL_PATH = Main.isDevelopmentEnvironment() ? Misc
      .includeTrailingBackslash(System.getProperty("user.dir")) : Misc
      .includeTrailingBackslash(Misc.includeTrailingBackslash(Misc
          .includeTrailingBackslash(System.getProperty("user.home"))
          + "Beowurks") + "JEquity");

  public final static String USER_NAME = System.getProperty("user.name");

  public final static String TEMPORARY_STOCK_PATH = Misc.includeTrailingBackslash(Misc.includeTrailingBackslash(Constants.TEMPORARY_PATH) + "Stocks");

  public final static String LOG_DOWNLOAD_STOCK_INFO = Constants.LOCAL_PATH + "DownloadStockInfo.log";
  public final static String LOG_COMPRESS_TABLES = Constants.LOCAL_PATH + "CompressTables.log";
  public final static String LOG_REGENERATE_VERIFY = Constants.LOCAL_PATH + "RegenerateVerify.log";

  public final static String OPTIONS_CONNECTION_ID = "com.beowurks.jequity.global.action.connections.ServerOptionsPanelController";
  public final static String OPTIONS_WAREHOUSE_ID = "com.beowurks.jequity.global.action.warehouses.WarehouseOptionsPanelController";
  public final static String OPTIONS_MISCELLANEOUS_ID = "com.beowurks.jequity.global.action.miscellaneous.MiscellaneousOptionsPanelController";

  //************************************************************
  // Used by Sample Data
  public final static String SAMPLE_DATA_URL = "http://www.beowurks.com/Software/JEquity/SampleData/SampleData.2.0.xml";
  public final static String SAMPLE_DATA_TEMPFILE = Misc.includeTrailingBackslash(Constants.TEMPORARY_PATH) + "SampleData.2.0.xml";

  //************************************************************
  // Used by Backup / Restore
  public final static String XML_ROOT_LABEL = "Records";
  public final static String XML_RECORDS_LABEL = "jequity";

  public final static String XML_GROUP_DESCRIPTION = "group";

  public final static String XML_DESCRIPTION = "description";
  public final static String XML_ACCOUNT = "account";
  public final static String XML_CATEGORY = "category";
  public final static String XML_COMMENTS = "comments";
  public final static String XML_PRICE = "price";
  public final static String XML_SHARES = "shares";
  public final static String XML_SYMBOL = "symbol";
  public final static String XML_TYPE = "type";
  public final static String XML_RETIREMENT = "retirement";
  public final static String XML_VALUATIONDATE = "valuationdate";

  public final static String XML_TRUE = "true";
  public final static String XML_FALSE = "false";

  //************************************************************
  // Used by AppProperties
  // I choose 100, 200, etc so I could insert other drivers in the future
  // while maintaining alphbetical order. I discovered that this is not needed;
  // I can presort RDBMS_DRIVERS in this file. Oh well. . . .
  public static final int DRIVER_KEY_DERBY = 100;
  public static final int DRIVER_KEY_MYSQL5 = 200;
  public static final int DRIVER_KEY_POSTGRESQL91 = 300;

  public static final int DAILY_INTERVAL_NEVER = -1;

  public final static String CONNECTION_RDBMS_KEY = "connection.rdbms.key";
  public final static String CONNECTION_DATABASE = "connection.database";
  public final static String CONNECTION_HOST = "connection.host";
  public final static String CONNECTION_USER = "connection.user";
  public final static String CONNECTION_PASSWORD = "connection.password";

  public final static String BACKUP_RESTORE_FOLDER = "backup.restore.folder";

  // Needed to redo the interval and start arrays. So I had to channge
  // DAILY_INTERVAL_KEY & DAILY_START_KEY by adding javafx to both.
  public final static String DAILY_INTERVAL_KEY = "daily.interval.key.javafx";

  // And yes, HISTORICAL_START should end with a '.'.
  public final static String HISTORICAL_START = "historical.start.";
  public final static String HISTORICAL_START_DEFAULT = "historical.start.defaultvalueforstart";

  public final static String FLYWAY_ALWAYS_CHECK = "flyway.always.check";
  public final static String FLYWAY_SUCCESSFUL_JEQUITY = "flyway.sucessful.jequity";

  public final static String USER_FILENAME = Constants.USER_NAME + ".Properties";

  // Below are all read-only values:
  //
  // According to the Derby Developer Guide,
  // "Note: These user names are case-sensitive for user authentication."
  public static final String DERBY_USERNAME = "JEquity";
  // DO NOT change the following passwords . . . ever.
  public static final String DERBY_DEFAULT_PASSWORD = "DeFau1t1l*l1PassW0rd";
  public static final String DERBY_BOOT_PASSWORD = "Wolf*Sky1ine)&(DugBite";

  public final static String DERBY_PATH = (Main.isDevelopmentEnvironment()
      ? (Misc.isWindows() ? "d:\\temp\\ApacheDerby\\" : System.getProperty("user.home") + "/ApacheDerby/")
      : Constants.LOCAL_PATH) + "JEquityDB";

  public final static IntegerKeyItem[] RDBMS_DRIVERS =
      {
          new IntegerKeyItem(Constants.DRIVER_KEY_DERBY, "Apache Derby (default)"),
          new IntegerKeyItem(Constants.DRIVER_KEY_MYSQL5, "MySQL 5.0+"),
          new IntegerKeyItem(Constants.DRIVER_KEY_POSTGRESQL91, "PostgreSQL 9.1+")
      };

  public final static IntegerKeyItem[] DAILY_INTERVAL =
      {
          new IntegerKeyItem(30 * 60 * 1000, "Every 30 Minutes"),
          new IntegerKeyItem(60 * 60 * 1000, "Every Hour"),
          new IntegerKeyItem(120 * 60 * 1000, "Every 2 Hours"),
          new IntegerKeyItem(Constants.DAILY_INTERVAL_NEVER, "Never")
      };


  // 1 second delay as it's in milliseconds.
  public final static int TIMER_SUMMARY_UPDATE_DELAY = 1000;

  public final static int UNINITIALIZED = -1;

  public final static int TOP_COMPONENT_EDITOR_ALWAYS_OPEN_COUNT = 4;

  public final static int ROW_UNKNOWN = Integer.MIN_VALUE;
  public final static int KEY_UNDETERMINED = Integer.MIN_VALUE;
  public final static int COLUMN_UNKNOWN = Integer.MIN_VALUE;

  public final static String EDITOR_TC_GROUP = "EditorWindowGroupTopComponent";
  public final static String EDITOR_TC_PRINT = "EditorWindowReportsTopComponent";

  public static final String CATEGORY_TYPE_DELIMITER = ":";

  public static final String EXPORT_FILECHOOSER_FILENAME = "export.filechooser.filename";

  //************************************************************
  // The following is used by the downloads in global.warehouse
  public final static int WEB_TIME_OUT = 7500;

  // Just Google 'what is my user agent'
  public final static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36";
  public final static String UNKNOWN_STOCK_SYMBOL = "Unknown Stock Symbol";

  public final static String YAHOO_SYMBOL = "[Symbol]";
  public final static String YAHOO_STARTDAY = "[StartDay]";
  public final static String YAHOO_STARTMONTH = "[StartMonth]";
  public final static String YAHOO_STARTYEAR = "[StartYear]";
  public final static String YAHOO_ENDDAY = "[EndDay]";
  public final static String YAHOO_ENDMONTH = "[EndMonth]";
  public final static String YAHOO_ENDYEAR = "[EndYear]";

  public final static String YAHOO_HISTORICAL_PROTOCOL = "http";
  public final static String YAHOO_HISTORICAL_HOST = "ichart.finance.yahoo.com";
  public final static int YAHOO_HISTORICAL_PORT = 80;
  public final static String YAHOO_HISTORICAL_FILE = "/table.csv?s="
      + Constants.YAHOO_SYMBOL + "&a="
      + Constants.YAHOO_STARTMONTH + "&b="
      + Constants.YAHOO_STARTDAY + "&c="
      + Constants.YAHOO_STARTYEAR + "&d="
      + Constants.YAHOO_ENDMONTH + "&e="
      + Constants.YAHOO_ENDDAY + "&f="
      + Constants.YAHOO_ENDYEAR + "&g=d&ignore=.csv";

  public final static String YAHOO_SYMBOL_PROTOCOL = "http";
  // https://stackoverflow.com/questions/44292230/java-read-csv-file-from-the-web
  //   The server actually sends a 301 response redirection
  public final static String YAHOO_SYMBOL_HOST = "download.finance.yahoo.com";

  public final static int YAHOO_SYMBOL_PORT = 80;
  public final static String YAHOO_SYMBOL_FILE = "/d/quotes.csv?s="
      + Constants.YAHOO_SYMBOL + "&f=";

  public final static String[][] YAHOO_CODES =
      {
          {
              "s", "Symbol"
          },
          {
              "n", "Name"
          },
          {
              "l1", "Last Trade"
          },
          {
              "p", "Previous Close"
          },
          {
              "o", "Opened"
          },
          {
              "t8", "1 yr Target Price"
          },
          {
              "b", "Bid"
          },
          {
              "a", "Ask"
          },
          {
              "m", "Day's Range"
          },
          {
              "w", "52 week Range"
          },
          {
              "v", "Volume"
          },
          {
              "a2", "Average Daily Volume"
          },
          {
              "j1", "Market Capitalization"
          },
          {
              "r", "P/E Ratio"
          },
          {
              "e", "Earnings per Share"
          },
          {
              "y", "Dividend Yield"
          },

      };

  public final static String YAHOO_DAILY_HTML = "https://finance.yahoo.com/quote/%s?ltr=1";

  public final static long BAD_DOWNLOAD = -1;

  public final static int THREAD_ERROR_DISPLAY_DELAY = 2500;

  public final static String YAHOO_DAILY_LAST_TRADE_HTML_CODE = "#quote-header-info div[class^=Mt] span[class^=Trsdu]";

  public final static String YAHOO_DAILY_MARKER = "**";
  public final static String YAHOO_DAILY_PREVCLOSE = "Previous Close";
  public final static String YAHOO_DAILY_OPEN = "Open";
  public final static String YAHOO_DAILY_BID = "Bid";
  public final static String YAHOO_DAILY_ASK = "Ask";
  public final static String YAHOO_DAILY_DAYRANGE = "Day's Range";
  public final static String YAHOO_DAILY_YEARRANGE = "52 Week Range";
  public final static String YAHOO_DAILY_VOLUME = "Volume";
  public final static String YAHOO_DAILY_AVGVOLUME = "Avg. Volume";
  public final static String YAHOO_DAILY_MARKETCAP = "Market Cap";
  public final static String YAHOO_DAILY_PE = "PE Ratio (TTM)";
  public final static String YAHOO_DAILY_EPS = "EPS (TTM)";
  public final static String YAHOO_DAILY_DIVIDENDYIELD = "Dividend & Yield";
  public final static String YAHOO_DAILY_TARGETEST = "1y Target Est";

  //************************************************************
  // The following is used by the Sorting Tables
  public final static String FINANCIAL_ID = "ID #";
  public final static String FINANCIAL_DESCRIPTION = "Description";
  public final static String FINANCIAL_ACCOUNT = "Account";
  public final static String FINANCIAL_TYPE = "Type";
  public final static String FINANCIAL_CATEGORY = "Category";
  public final static String FINANCIAL_SHARES = "Shares";
  public final static String FINANCIAL_PRICE = "Price / Shares ($)";
  public final static String FINANCIAL_VALUATION = "Valuation Date";
  public final static String FINANCIAL_RETIREMENT = "Retirement (?)";
  public final static String FINANCIAL_SYMBOL = "Stock Symbol";
  public final static String FINANCIAL_VALUE = "Value ($)";
  public final static String FINANCIAL_COMMENTS = "Comments";

  public final static String GROUP_ID = "ID #";
  public final static String GROUP_DESCRIPTION = "Description";

  public final static String SYMBOL_ID = "Symbol";
  public final static String SYMBOL_DESCRIPTION = "Description";
  public final static String SYMBOL_ASKING = "Asking ($)";
  public final static String SYMBOL_AVG_VOL = "Average Volumne";
  public final static String SYMBOL_BIDDING = "Bidding ($)";
  public final static String SYMBOL_CHANGE = "Change";
  public final static String SYMBOL_DAY_RANGE = "Day Range";
  public final static String SYMBOL_DIV_YLD = "Dividend Yield";
  public final static String SYMBOL_EARNINGS = "Earnings / Share ($)";
  public final static String SYMBOL_LASTTRADE = "Last Trade ($)";
  public final static String SYMBOL_MARKET_CAP = "Market Cap";
  public final static String SYMBOL_OPENED = "Opened ($)";
  public final static String SYMBOL_PREV_CLOSE = "Previous Close ($)";
  public final static String SYMBOL_PRICE_EARN = "Price Earnings ($)";
  public final static String SYMBOL_TARGET_EST = "Target Estimates ($)";
  public final static String SYMBOL_TRADE_TIME = "Trade Time";
  public final static String SYMBOL_VOLUME = "Volume";
  public final static String SYMBOL_YEAR_RANGE = "Year Range";

  //************************************************************
  // The following is used by Export.
  public final static int FILEEXPORT_XLS_21 = 1;
  public final static int FILEEXPORT_TABTEXT = 2;

  //************************************************************
  // The following is used by Flyway.
  public final static String FLYWAY_MYSQL = "MySQL";
  public final static String FLYWAY_DERBY = "Apache Derby";
  public final static String FLYWAY_POSTGRES = "PostgreSQL";

  public final static String FLYWAY_JEQUITY_SCHEMA = "JEquityRCP";

  public final static String FLYWAY_DERBY_DEFAULT_SCHEMA = Constants.DERBY_USERNAME.toUpperCase();

  // -----------------------------------------------------------------------------
  private Constants()
  {

  }
  // -----------------------------------------------------------------------------

}
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
