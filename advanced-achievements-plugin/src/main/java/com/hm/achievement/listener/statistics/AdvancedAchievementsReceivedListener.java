package com.hm.achievement.listener.statistics;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

import com.hm.achievement.category.NormalAchievements;
import com.hm.achievement.config.AchievementMap;
import com.hm.achievement.db.CacheManager;
import com.hm.achievement.utils.PostPlayerAdvancedAchievementEvent;

/**
 * Listener class to deal with AdvancedAchievementsReceived achievements.
 *
 * @author Krakenied
 *
 */
@Singleton
public class AdvancedAchievementsReceivedListener extends AbstractListener {

	@Inject
	public AdvancedAchievementsReceivedListener(@Named("main") YamlConfiguration mainConfig, AchievementMap achievementMap,
			CacheManager cacheManager) {
		super(NormalAchievements.ADVANCEDACHIEVEMENTSRECEIVED, mainConfig, achievementMap, cacheManager);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerDoneAdvancement(PostPlayerAdvancedAchievementEvent event) {
		updateStatisticAndAwardAchievementsIfAvailable(event.getPlayer(), 1);
	}
}
