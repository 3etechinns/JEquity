/*
 * JEquity
 * Copyright(c) 2008-2019, Beowurks
 * Original Author: Eddie Fann
 * License: Eclipse Public License - v 2.0 (https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html)
 *
 */
package com.beowurks.jequity.dao.combobox;

// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
public class IntegerKeyItem
{

  private final int fnKey;
  private final String fcDescription;

  // ---------------------------------------------------------------------------------------------------------------------
  public IntegerKeyItem(final int tnKey, final String tcDescription)
  {
    this.fnKey = tnKey;
    this.fcDescription = tcDescription;
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public int getKey()
  {
    return (this.fnKey);
  }

  // ---------------------------------------------------------------------------------------------------------------------
  public String getDescription()
  {
    return (this.fcDescription);
  }

  // ---------------------------------------------------------------------------------------------------------------------
  // By the way, toString is used by the JComboBox renderer.
  @Override
  public String toString()
  {
    return (this.fcDescription);
  }
  // ---------------------------------------------------------------------------------------------------------------------
}
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------
