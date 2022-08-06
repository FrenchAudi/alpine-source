package me.alpine.mod;

import lombok.Getter;
import lombok.Setter;
import me.alpine.event.EventManager;
import me.alpine.mod.property.BaseProperty;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class Mod {
    protected final Minecraft mc = Minecraft.getMinecraft();

    @Getter private final String name;
    @Getter private final String description;
    @Getter private final EnumModCategory category;
    @Getter @Setter private String displayName;
    private boolean enabled;

    @Getter private final List<BaseProperty> properties;

    public Mod(String name, String description, EnumModCategory category) {
        this.name = name;
        this.displayName = name;
        this.description = description;
        this.category = category;
        this.enabled = false;
        this.properties = new ArrayList<>();
    }

    public void onEnable() {
        EventManager.register(this);
    }

    public void onDisable() {
        EventManager.unregister(this);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        setEnabled(!isEnabled());
    }
}
