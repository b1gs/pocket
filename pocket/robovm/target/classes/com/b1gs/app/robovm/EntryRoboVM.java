package com.b1gs.app.robovm;

import com.toxic.robovm.PlatformRoboVM;
import com.b1gs.app.core.Entry;


/**
 * <p>
 *  Launcher of roboVM platform's.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class EntryRoboVM extends PlatformRoboVM {
    
    /**
     * <p>
     *  Default constructor of java platform.
     * </p> 
     * <br/>
     * @param app instance of application
     */
    public EntryRoboVM() {
      
    }

    /**
     * <p>
     *  Entry point for roboVM project.
     * </p>
     * <br/>
     *  Strelock : add link here!
     * <br/>
     * @param args
     */
    public static void main(String[] args) {
      PlatformRoboVM.setArgs(args);
      PlatformRoboVM.setApp(new Entry());
      (new EntryRoboVM()).start();;
    }

}
