package rCode.help.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoolDown {

    private Map<UUID, Long> cool;

    public CoolDown(HashMap<UUID, Long> cool) {
        this.cool = cool;
    }

    public void setCool(UUID uuid) {
        cool.put(uuid, System.currentTimeMillis());
    }

    public boolean hasCool(UUID uuid, int time) {
        if (cool.containsKey(uuid)) {
            long timeleft = ((cool.get(uuid) / 1000)+time) - (System.currentTimeMillis() / 1000);
            if (timeleft > 0) {
                return true;
            } else
                return false;
            } else

        return false;
    }

    public long czasCool(UUID uuid, int time) {
        long timeleft = ((cool.get(uuid) / 1000) + time) - (System.currentTimeMillis()/1000);
        return timeleft;
    }

}
