/*
 * J'Equity
 * Copyright(c) 2008-2017
 * Original Author: Eddie Fann
 * License: Eclipse Public License
 *
 */
package com.beowurks.jequity.dao.hibernate;

import org.hibernate.dialect.PostgreSQL91Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;

// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
public class PostgreSQL91DialectPlus extends PostgreSQL91Dialect
{
  // -----------------------------------------------------------------------------

  @Override
  public IdentityColumnSupport getIdentityColumnSupport()
  {
    return new PostgreSQL81IdentityColumnSupportPlus();
  }
  // -----------------------------------------------------------------------------

}
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------

