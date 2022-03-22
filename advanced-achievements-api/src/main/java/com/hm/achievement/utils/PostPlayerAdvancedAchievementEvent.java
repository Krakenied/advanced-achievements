package com.hm.achievement.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.hm.achievement.domain.Achievement;

/**
 * Class representing an uncancellable event fired after {@link PlayerAdvancedAchievementEvent}.
 *
 * @author Krakenied
 */
public class PostPlayerAdvancedAchievementEvent extends Event {

	private static final HandlerList HANDLERS = new HandlerList();

	private final Player player;
	private final Achievement achievement;

	public PostPlayerAdvancedAchievementEvent(Player player, Achievement achievement) {
		this.player = player;
		this.achievement = achievement;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	public Player getPlayer() {
		return player;
	}

	public Achievement getAchievement() {
		return achievement;
	}

}
