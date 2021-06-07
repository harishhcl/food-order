package com.hcl.foodorder.domain.events;

import java.util.Date;

import com.hcl.foodorder.domain.restaurant.MenuItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Harishkumar Reddy
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemEvent {
	
	private String eventId;
	private EventStatus status;
	private MenuItem payload;
	private Date createdDate;
	private Date updatedDate;
}
