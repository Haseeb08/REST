package com.example.sharingapp;

import android.content.Context;

/**
 * Command to delete a bid
 */
public class DeleteBidCommand extends Command {

    
    private Bid bid;
    

    public DeleteBidCommand(Bid bi) {
       this.bid = bid;
       }

    // Delete bid remotely
    public void execute(){
       ElasticSearchManager.RemoveBidTask remove_bid_task = new ElasticSearchManager.RemoveBidTask();
        Remove_bid_task.execute(bid);

        // use get() to access the return of RemoveBidTask. i.e. RemoveBidTask returns a Boolean to
        // indicate if the bid was successfully saved to the remote server
        try {
            if(remove_bid_task.get()) {
                super.setIsExecuted(true);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            super.setIsExecuted(false);
        }
       
    }
}
