package com.hm.achievement.command.executable;

import java.util.Calendar;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.hm.achievement.AdvancedAchievements;
import org.bukkit.configuration.file.YamlConfiguration;

import com.hm.achievement.db.AbstractDatabaseManager;
import com.hm.achievement.utils.SoundPlayer;

/**
 * Class in charge of handling the /aach week command, which displays weekly rankings.
 *
 * @author Pyves
 */
@Singleton
@CommandSpec(name = "week", permission = "week", minArgs = 1, maxArgs = 2)
public class WeekCommand extends AbstractRankingCommand {

	@Inject
	public WeekCommand(@Named("main") YamlConfiguration mainConfig, @Named("lang") YamlConfiguration langConfig,
			StringBuilder pluginHeader, Logger logger, AdvancedAchievements advancedAchievements,
			AbstractDatabaseManager databaseManager, SoundPlayer soundPlayer) {
		super(mainConfig, langConfig, pluginHeader, logger, "week-achievement", advancedAchievements, databaseManager,
				soundPlayer);
	}

	@Override
	long getRankingStartTime() {
		Calendar c = Calendar.getInstance();
		// Set calendar to the first day of the week.
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTimeInMillis();
	}
}
