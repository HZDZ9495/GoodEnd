package net.hzdz.goodend.procedure;

import net.minecraftforge.fml.common.FMLCommonHandler;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.hzdz.goodend.ElementsGoodendMod;

import java.util.Map;

@ElementsGoodendMod.ModElement.Tag
public class ProcedureSuicideAsk extends ElementsGoodendMod.ModElement {
	public ProcedureSuicideAsk(ElementsGoodendMod instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SuicideAsk!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SuicideAsk!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).setHealth((float) 0);
		{
			MinecraftServer mcserv = FMLCommonHandler.instance().getMinecraftServerInstance();
			if (mcserv != null)
				mcserv.getPlayerList()
						.sendMessage(new TextComponentString((((entity.getDisplayName().getUnformattedText())) + "" + ("\u6B7B\u4E86"))));
		}
	}
}
