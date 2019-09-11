package com.tarantsoff.telegraph;

import org.telegram.telegraph.ExecutorOptions;
import org.telegram.telegraph.TelegraphContext;
import org.telegram.telegraph.TelegraphContextInitializer;
import org.telegram.telegraph.TelegraphLogger;
import org.telegram.telegraph.api.methods.CreateAccount;
import org.telegram.telegraph.api.methods.GetAccountInfo;
import org.telegram.telegraph.api.objects.Account;
import org.telegram.telegraph.exceptions.TelegraphException;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class CreateAcc {

    static {
        TelegraphLogger.setLevel(Level.ALL);
        TelegraphLogger.registerLogger(new ConsoleHandler());

        // Initialize context
        TelegraphContextInitializer.init();
        TelegraphContext.registerInstance(ExecutorOptions.class, new ExecutorOptions());

    }

    public static void main(String[] args) {
        // Set up logger

        try {
            // Create account
            Account account =
                    new CreateAccount("TarantsoffDemoBot")
                            .setAuthorName("TarantsoffDemoBot")
                            .execute();

            // Get account info
            Account accountInfo =
                    new GetAccountInfo(account.getAccessToken())
                    .execute();
            System.out.println("accountInfo = " + accountInfo);

        } catch (TelegraphException e) {
            TelegraphLogger.severe("MAIN", e);
        }
    }
}
