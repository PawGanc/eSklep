package com.moviestore.domain.security;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.moviestore.domain.User;

@Entity
public class PasswordResetToken {

	private static final int EXPIRRATON =  ;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String token;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable=false, name="user_id")
	private User user;
	
		
	private Date expiryDate;
	
	public PasswordResetToken() {}
	
	public PasswordResetToken(final String token, final User user ) {
		super ();
		
		this.token = token;
		this.user = user;
		this.expiryDate = calculateExpiryDate(EXPIRRATON);
	}
	
	private Date calculateExpiryDate (final int expiryTimeInMinuts) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinuts);
		return new Date(cal.getTime().getTime());
			}
	
	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRRATON);
			}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static int getExpirraton() {
		return EXPIRRATON;
	}

	@Override
	public String toString() {
		return "PasswordResetToken [id=" + id + ", user=" + user + ", token=" + token + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
	
}
