package com.mawie.Eshop.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@Entity
@XmlRootElement(name = "Watch")
public class Watch
{
    @Id
    @GeneratedValue
    private long id;
    
    @NotNull(message = "Title is mandatory")
    private String title;
    
    @Min( value = 1, message = "Price should be higher than 1")
    private Integer price;
    
    private String description;
    
    @Column( length = 100000 )
    private byte[] picture;
    
    public Watch( String title, Integer price, String description, byte[] picture)
    {
            this.title = title;
            this.price = price;
            this.description = description;
            this.picture = picture;
    }

    public Watch()
    {
    
    }
    public long getId()
    {
        return id;
    }
    
    public void setId( long id )
    {
        this.id = id;
    }
    
    public String getTitle()
        {
            return title;
        }
    
    public void setTitle( String title )
    {
        this.title = title;
    }
    
    public Integer getPrice()
    {
        return price;
    }
    
    public void setPrice( Integer price )
    {
        this.price = price;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription( String description )
    {
        this.description = description;
    }
    
    public byte[] getPicture()
    {
        return picture;
    }

    public void setPicture( byte[] picture )
    {
        this.picture = picture;
    }
    
    @Override
  public boolean equals(Object o)
    {
    if (this == o)
      return true;
    if (!(o instanceof Watch))
      return false;
    Watch watch = (Watch) o;
    return Objects.equals(this.title, watch.title)
            && Objects.equals( this.id, watch.id )
            && Objects.equals(this.description, watch.description)
            && Objects.equals(this.price, watch.price)
            && Objects.equals( this.picture, watch.picture );
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(
            this.id,
            this.title,
            this.description,
            this.price,
            this.picture );
  }

  @Override
  public String toString()
  {
    return "Watch{" + ",  id='" + this.id + '\''
            + ", title='" + this.title + '\''
            + ", description='" + this.description + '\''
            + ", price='" + this.price + '\''
            + ", picture='" + this.picture + '\''
            + '}';
  }
  
}
