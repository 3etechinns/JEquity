/*
 * JEquity
 * Copyright(c) 2008-2019, Beowurks
 * Original Author: Eddie Fann
 * License: Eclipse Public License - v 2.0 (https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html)
 *
 */

package com.beowurks.jequity.dao.combobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
public class TaxStatusList
{
  // Here's a discussion of when INSTANCE will be initialized:
  // http://stackoverflow.com/questions/13724230/singleton-and-public-static-variable-java
  // Accordingly, it should be initialized when first accessed.
  public static final TaxStatusList INSTANCE = new TaxStatusList();

  private final ObservableList<StringKeyItem> faOptions = FXCollections.observableArrayList();

  // ---------------------------------------------------------------------------------------------------------------------
  private TaxStatusList()
  {
    // Let's not change these keys as they will be stored in the database.
    this.faOptions.add(new StringKeyItem("T", "Taxable"));
    this.faOptions.add(new StringKeyItem("D", "Tax Deferred"));
    this.faOptions.add(new StringKeyItem("F", "Tax Free"));
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public ObservableList<StringKeyItem> getList()
  {
    return (this.faOptions);
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public int getCount()
  {
    return (this.faOptions.size());
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public int getIndex(final String tcKey)
  {
    int lnIndex = -1;
    for (final StringKeyItem loOption : this.faOptions)
    {
      if (loOption.getKey().equals(tcKey))
      {
        lnIndex = this.faOptions.indexOf(loOption);
        break;
      }
    }

    return (lnIndex);
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public StringKeyItem getItem(final String tcKey)
  {
    StringKeyItem loItem = null;
    for (final StringKeyItem loOption : this.faOptions)
    {
      if (loOption.getKey().equals(tcKey))
      {
        loItem = loOption;
        break;
      }
    }

    return (loItem);
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public String getDescription(final int tnIndex)
  {
    if ((tnIndex >= 0) && (tnIndex < this.faOptions.size()))
    {
      return (this.faOptions.get(tnIndex).getDescription());
    }

    return ("");
  }

  // ---------------------------------------------------------------------------------------------------------------------

}
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
