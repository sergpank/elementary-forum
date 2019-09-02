package org.elementary.forum.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ban")
public class Ban
{
  @Id
  @GeneratedValue(generator="increment")
  @GenericGenerator(name="increment", strategy = "increment")
  private long id;

  public Ban()
  {

  }

  public Ban(String login, String reason)
  {
    this.login = login;
    this.reason = reason;
  }

  @Column
  private String login;

  @Column
  private String reason;

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public String getLogin()
  {
    return login;
  }

  public void setLogin(String login)
  {
    this.login = login;
  }

  public String getReason()
  {
    return reason;
  }

  public void setReason(String reason)
  {
    this.reason = reason;
  }

  @Override
  public String toString()
  {
    return "BannedUser{login='" + login + '\'' +
        ", reason='" + reason + '\'' +
        '}';
  }
}
