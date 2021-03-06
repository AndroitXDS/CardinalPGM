package in.twizmwaz.cardinal.module.modules.friendlyFire;

import in.twizmwaz.cardinal.match.Match;
import in.twizmwaz.cardinal.module.LoadTime;
import in.twizmwaz.cardinal.module.ModuleBuilder;
import in.twizmwaz.cardinal.module.ModuleCollection;
import in.twizmwaz.cardinal.module.ModuleLoadTime;

@LoadTime(ModuleLoadTime.LATEST)
public class FriendlyFireBuilder implements ModuleBuilder {

    @Override
    public ModuleCollection<FriendlyFire> load(Match match) {
        ModuleCollection<FriendlyFire> results = new ModuleCollection<>();
        boolean enabled = true;
        boolean arrowReturn = true;
        try {
            if (match.getDocument().getRootElement().getChild("friendlyfire").getText().equalsIgnoreCase("on")) {
                enabled = false;
            }
        } catch (NullPointerException e) {

        }
        try {
            if (match.getDocument().getRootElement().getChild("friendlyfirerefund").getText().equalsIgnoreCase("off")) {
                arrowReturn = false;
            }
        } catch (NullPointerException e) {

        }
        results.add(new FriendlyFire(enabled, arrowReturn));
        return results;
    }

}
