package fr.maxlego08.zvoteparty.command.commands;

import fr.maxlego08.zvoteparty.ZVotePartyPlugin;
import fr.maxlego08.zvoteparty.api.enums.Message;
import fr.maxlego08.zvoteparty.command.VCommand;
import fr.maxlego08.zvoteparty.api.enums.Permission;

import fr.maxlego08.zvoteparty.zcore.utils.commands.CommandType;

public class CommandFakeVote extends VCommand {

    public CommandFakeVote(ZVotePartyPlugin plugin) {
        super(plugin);
        setDescription(Message.DESCRIPTION_FAKEVOTE);
        addSubCommand("fakevote");
        setPermission(Permission.ZVOTEPARTY_FAKEVOTE);
        addRequireArg("player");
    }

    @Override
    protected CommandType perform(ZVotePartyPlugin plugin) {
        String player = argAsString(0);
        if (player == null || player.isEmpty()) {
            //sendMessage(Message.INVALID_PLAYER);
            //return CommandType.FAILURE;
            return CommandType.SYNTAX_ERROR;
        }

        if (!plugin.getServer().getPlayer(player).isOnline()) {
            return CommandType.SYNTAX_ERROR;        
        }
        plugin.getManager().vote(player, "TestService.org", true);
        return CommandType.SUCCESS;
    }
}
