/*
 * J'Equity
 * Copyright(c) 2008-2017
 * Original Author: Eddie Fann
 * License: Eclipse Public License
 *
 */
package com.beowurks.jequity.dao.migration;

import com.beowurks.jequity.utility.Misc;

import java.sql.Connection;

// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
public class V3_2__Setup_Constraints extends MigrationHelper
{

  // -----------------------------------------------------------------------------
  @Override
  public void migrate(final Connection toConnection) throws Exception
  {
    Misc.setStatusText("Migration v3.2. . . .");

    this.foConnection = toConnection;

    this.executeStatements("ConstraintsSetup.sql");

  }
  // -----------------------------------------------------------------------------

}
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
