package committee.nova.skillfultweaker.compat.event.manager;

import committee.nova.skillfultweaker.compat.event.impl.SkillLevelEvent;
import committee.nova.skillfultweaker.compat.event.impl.SkillRegisterEvent;
import committee.nova.skillfultweaker.compat.event.impl.SkillXPEvent$Post;
import committee.nova.skillfultweaker.compat.event.impl.SkillXPEvent$Pre;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.event.EventManager")
public class CRTSkillfulEventManager {
    public static final CRTSkillfulEventManager INSTANCE = new CRTSkillfulEventManager();

    private final EventList<SkillRegisterEvent> listSkillRegister = new EventList<>();
    private final EventList<SkillXPEvent$Post> listSkillXPPost = new EventList<>();
    private final EventList<SkillXPEvent$Pre> listSkillXPPre = new EventList<>();
    private final EventList<SkillLevelEvent> listSkillLevel = new EventList<>();

    @ZenMethod
    public static CRTSkillfulEventManager getInstance() {
        return INSTANCE;
    }

    @ZenMethod
    public void clear() {
        listSkillRegister.clear();
        listSkillXPPost.clear();
        listSkillXPPre.clear();
        listSkillLevel.clear();
    }

    public boolean hasRegister() {
        return listSkillRegister.hasHandlers();
    }

    public boolean hasXPPost() {
        return listSkillXPPost.hasHandlers();
    }

    public boolean hasXPPre() {
        return listSkillXPPre.hasHandlers();
    }

    public boolean hasLevel() {
        return listSkillLevel.hasHandlers();
    }

    public void publishRegister(SkillRegisterEvent event) {
        listSkillRegister.publish(event);
    }

    public void publishXPPost(SkillXPEvent$Post event) {
        listSkillXPPost.publish(event);
    }

    public void publishXPPre(SkillXPEvent$Pre event) {
        listSkillXPPre.publish(event);
    }

    public void publishLevel(SkillLevelEvent event) {
        listSkillLevel.publish(event);
    }

    @ZenMethod
    public IEventHandle onSkillRegister(IEventHandler<SkillRegisterEvent> handler) {
        return listSkillRegister.add(handler);
    }

    @ZenMethod
    public IEventHandle onSkillXPPost(IEventHandler<SkillXPEvent$Post> handler) {
        return listSkillXPPost.add(handler);
    }

    @ZenMethod
    public IEventHandle onSkillXPPre(IEventHandler<SkillXPEvent$Pre> handler) {
        return listSkillXPPre.add(handler);
    }

    @ZenMethod
    public IEventHandle onSkillLevel(IEventHandler<SkillLevelEvent> handler) {
        return listSkillLevel.add(handler);
    }
}
