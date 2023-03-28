package committee.nova.skillfultweaker.compat.event.handler;

import committee.nova.skillful.event.impl.SkillXpEvent;
import committee.nova.skillful.storage.SkillfulStorage;
import committee.nova.skillfultweaker.compat.event.impl.SkillLevelEvent;
import committee.nova.skillfultweaker.compat.event.impl.SkillRegisterEvent;
import committee.nova.skillfultweaker.compat.event.impl.SkillXPEvent$Post;
import committee.nova.skillfultweaker.compat.event.impl.SkillXPEvent$Pre;
import committee.nova.skillfultweaker.compat.event.manager.CRTSkillfulEventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CRTEventHandler {
    @SubscribeEvent
    public static void onSkillRegister(SkillfulStorage.SkillRegisterEvent event) {
        if (CRTSkillfulEventManager.INSTANCE.hasRegister())
            CRTSkillfulEventManager.INSTANCE.publishRegister(new SkillRegisterEvent(event));
    }

    @SubscribeEvent
    public static void onSkillXPPost(SkillXpEvent.Post event) {
        if (CRTSkillfulEventManager.getInstance().hasXPPost())
            CRTSkillfulEventManager.INSTANCE.publishXPPost(new SkillXPEvent$Post(event));
    }

    @SubscribeEvent
    public static void onSkillXPPre(SkillXpEvent.Pre event) {
        if (CRTSkillfulEventManager.getInstance().hasXPPre())
            CRTSkillfulEventManager.INSTANCE.publishXPPre(new SkillXPEvent$Pre(event));
    }

    @SubscribeEvent
    public static void onSkillLevel(committee.nova.skillful.event.impl.SkillLevelEvent event) {
        if (CRTSkillfulEventManager.getInstance().hasLevel())
            CRTSkillfulEventManager.INSTANCE.publishLevel(new SkillLevelEvent(event));
    }
}
