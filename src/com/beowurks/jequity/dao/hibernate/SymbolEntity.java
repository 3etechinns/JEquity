/*
 * JEquity
 * Copyright(c) 2008-2018, Beowurks
 * Original Author: Eddie Fann
 * License: Eclipse Public License - v 2.0 (https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html)
 *
 */
// Generated by IntelliJ
// View | Tool Windows | Persistence
// Make sure that you have a hibernate.cfg.xml file in project
package com.beowurks.jequity.dao.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

// The schema is set in the configuration file. This way, the schema can be specific
// to the database. For example, MySQL doesn't have a schema in the traditional sense:
// The schema is the database.
// Case-sensitive issue solution: https://forum.hibernate.org/viewtopic.php?f=1&t=972808
@Entity
@Table(name = "`Symbol`", catalog = "")
public class SymbolEntity implements Serializable
{

  private static final long serialVersionUID = 1L;
  private String symbol = "";

  @Id
  @Column(name = "SYMBOL", nullable = false, insertable = true, updatable = true, length = 10)
  public String getSymbol()
  {
    return (this.symbol);
  }

  public void setSymbol(final String symbol)
  {
    this.symbol = symbol;
  }

  private String description = "";

  @Basic
  @Column(name = "DESCRIPTION", nullable = false, insertable = true, updatable = true, length = 255)
  public String getDescription()
  {
    return (this.description);
  }

  public void setDescription(final String description)
  {
    this.description = description;
  }

  private Double lasttrade = 0.0;

  @Basic
  @Column(name = "LASTTRADE", nullable = false, insertable = true, updatable = true, precision = 0)
  public Double getLastTrade()
  {
    return (this.lasttrade);
  }

  public void setLastTrade(final Double lasttrade)
  {
    this.lasttrade = lasttrade;
  }

  private Timestamp tradetime = new Timestamp(0);

  @Basic
  @Column(name = "TRADETIME", nullable = false, insertable = true, updatable = true)
  public Timestamp getTradeTime()
  {
    return (this.tradetime);
  }

  public void setTradeTime(final Timestamp tradetime)
  {
    this.tradetime = tradetime;
  }

  private String comments = "";

  @Basic
  @Column(name = "COMMENTS", nullable = false, insertable = true, updatable = true, length = 32700)
  public String getComments()
  {
    return (this.comments);
  }

  public void setComments(final String comments)
  {
    this.comments = comments;
  }

  private String historicalinfo = "";

  @Basic
  @Column(name = "HISTORICALINFO", nullable = false, insertable = true, updatable = true, length = 8192)
  public String getHistoricalInfo()
  {
    return (this.historicalinfo);
  }

  public void setHistoricalInfo(final String historicalinfo)
  {
    this.historicalinfo = historicalinfo;
  }

  @Override
  public boolean equals(final Object o)
  {
    if (this == o)
    {
      return (true);
    }
    if (o == null || this.getClass() != o.getClass())
    {
      return (false);
    }

    final SymbolEntity that = (SymbolEntity) o;

    if (this.description != null ? !this.description.equals(that.description) : that.description != null)
    {
      return (false);
    }
    if (this.lasttrade != null ? !this.lasttrade.equals(that.lasttrade) : that.lasttrade != null)
    {
      return (false);
    }
    if (this.symbol != null ? !this.symbol.equals(that.symbol) : that.symbol != null)
    {
      return (false);
    }
    if (this.tradetime != null ? !this.tradetime.equals(that.tradetime) : that.tradetime != null)
    {
      return (false);
    }
    if (this.comments != null ? !this.comments.equals(that.comments) : that.comments != null)
    {
      return (false);
    }
    return this.historicalinfo != null ? this.historicalinfo.equals(that.historicalinfo) : that.historicalinfo == null;
  }

  @Override
  public int hashCode()
  {
    int lnResult = this.symbol != null ? this.symbol.hashCode() : 0;

    lnResult = 31 * lnResult + (this.description != null ? this.description.hashCode() : 0);
    lnResult = 31 * lnResult + (this.lasttrade != null ? this.lasttrade.hashCode() : 0);
    lnResult = 31 * lnResult + (this.tradetime != null ? this.tradetime.hashCode() : 0);
    lnResult = 31 * lnResult + (this.comments != null ? this.comments.hashCode() : 0);
    lnResult = 31 * lnResult + (this.historicalinfo != null ? this.historicalinfo.hashCode() : 0);

    return (lnResult);
  }
}
