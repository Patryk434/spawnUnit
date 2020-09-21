
import arc.util.*;
import mindustry.content.*;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.mod.Mod;
import mindustry.type.UnitType;

public class unitSpawn extends Mod {
    //register commands that player can invoke in-game
    @Override
    public void registerClientCommands(CommandHandler handler){
        handler.<Player>register( "spawn", "<unit> <count> <team>", "Spawn units", (args, player) ->{
            if(!player.admin){
                player.sendMessage("[red]You are not admin");
                return;
            }
            UnitType sunit;
            switch (args[0]) {
                case "mono":
                    sunit = UnitTypes.mono;
                    break;
                case "flare":
                    sunit = UnitTypes.flare;
                    break;
                case "eclipse":
                    sunit = UnitTypes.eclipse;
                    break;
                case "horizon":
                    sunit = UnitTypes.horizon;
                    break;
                case "zenith":
                    sunit = UnitTypes.zenith;
                    break;
                case "antumbra":
                    sunit = UnitTypes.antumbra;
                    break;
                case "mace":
                    sunit = UnitTypes.mace;
                    break;
                case "scepter":
                    sunit = UnitTypes.scepter;
                    break;
                case "dagger":
                    sunit = UnitTypes.dagger;
                    break;
                case "crawler":
                    sunit = UnitTypes.crawler;
                    break;
                case "reign":
                    sunit = UnitTypes.reign;
                    break;
                case "fortress":
                    sunit = UnitTypes.fortress;
                    break;
                case "nova":
                    sunit = UnitTypes.nova;
                    break;
                case "pulsar":
                    sunit = UnitTypes.pulsar;
                    break;
                case "quasar":
                    sunit = UnitTypes.quasar;
                    break;
                case "atrax":
                    sunit = UnitTypes.atrax;
                    break;
                case "spircot":
                    sunit = UnitTypes.spiroct;
                    break;
                case "arkyid":
                    sunit = UnitTypes.arkyid;
                    break;
                case "toxopid":
                    sunit = UnitTypes.toxopid;
                    break;
                case "poly":
                    sunit = UnitTypes.poly;
                    break;
                case "mega":
                    sunit = UnitTypes.mega;
                    break;
                case "risso":
                    sunit = UnitTypes.risso;
                    break;
                case "minke":
                    sunit = UnitTypes.minke;
                    break;
                case "bryde":
                    sunit = UnitTypes.bryde;
                    break;
                default:
                    player.sendMessage("[red]Units: [accent]dagger, mace, fortress, scepter, reign, nova, pulsar, quasar, crawler, atrax, spiroct, arkyid, toxopid, flare, horizon, zenith, antumbrae, eclipse, mono, poly, mega, risso, minke, bryde.");
                    return;
            }
            int count;
            try {
                count = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                player.sendMessage("[red]Count must be number!");
                return;
            }
            Team tteam;
            switch (args[2]) {
                case "sharded":
                    tteam = Team.sharded;
                    break;
                case "blue":
                    tteam = Team.blue;
                    break;
                case "crux":
                    tteam = Team.crux;
                    break;
                case "derelict":
                    tteam = Team.derelict;
                    break;
                case "green":
                    tteam = Team.green;
                    break;
                case "purple":
                    tteam = Team.purple;
                    break;
                default:
                    player.sendMessage("[accent]Teams: [yellow]sharded[], [blue]blue[], [red]crux[], [gray]derelict[], [green]green[], [purple]purple[].");
                    return;
            }

            for (int i = 0; count > i; i++) {
                Unit tunit = sunit.create(tteam);
                tunit.set(Float.parseFloat(String.valueOf(player.getX())), Float.parseFloat(String.valueOf(player.getY())));
                tunit.add();
            }
            player.sendMessage("[green]You are spawning" + " " +"[accent]"+count + " " +"[accent]"+sunit + " " + "[green]for" + " " +"[accent]"+tteam + " " + "[green]team");

        });
    }
}
