package net.hzdz.goodend.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Score;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.hzdz.goodend.ElementsGoodendMod;

import java.util.Map;

@ElementsGoodendMod.ModElement.Tag
public class ProcedureDeathAsk extends ElementsGoodendMod.ModElement {
	public ProcedureDeathAsk(ElementsGoodendMod instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DeathAsk!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DeathAsk!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(
						new TextComponentString((((entity.getDisplayName().getUnformattedText())) + "" + ("\u6B7B\u4EA1") + "" + ((new Object() {
							public int getScore(String score) {
								if (entity instanceof EntityPlayer) {
									Scoreboard _sc = ((EntityPlayer) entity).getWorldScoreboard();
									ScoreObjective _so = _sc.getObjective(score);
									if (_so != null) {
										Score _scr = _sc.getOrCreateScore(((EntityPlayer) entity).getGameProfile().getName(), _so);
										return _scr.getScorePoints();
									}
								}
								return 0;
							}
						}.getScore("ge:die"))) + "" + ("\u6B21"))));
		}
	}
}
