package com.hcl.foodorder.search.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author Harishkumar Reddy
 *
 */
public interface MenuItemStream {
	String INPUT = "menu-item-output";

	@Input(INPUT)
	MessageChannel sendEmployeeMessage();
}
