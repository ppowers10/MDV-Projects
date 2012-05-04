//
//  AppDelegate.m
//  Project1
//
//  Created by Patrick Powers on 5/3/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "AppDelegate.h"

@implementation AppDelegate

@synthesize window = _window;

- (void)dealloc
{
    [_window release];
    [super dealloc];
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    
//  1.  Create a variable using the float data type. Cast the float to an int and using NSLog, output both the initial float value as well as the int value.
    float gasTank = 12.2f;
    float gasCurrent = 5.5; 
    bool needGasFeeling = true;
    int Tank = (int)gasTank;
    
    NSLog(@"My gas tank holds %.1f gallons which is roughly %d gallons.", gasTank, Tank);  
    
//  2.  Perform an AND, OR comparison. Use float, int and bool types
//  3.  Use an if, else if and else check using any of the data types of your choice.    
    if (gasCurrent > 6 || needGasFeeling == false)
    {
        NSLog(@"I'm just not going to worry about gas right now.");
    }
    else if (gasCurrent <= 2 && needGasFeeling == true)
    {
        NSLog(@"I have %.1f gallon(s) of gas left, I better get gas.", gasCurrent);
    }
    else
    {
        NSLog(@"I have %.1f gallon(s) of gas left, but it might not be a bad idea to get gas now.");
    }    

//  4.  Perform a single for loop printing out values to the console
    for (int x=10; x > 0; x--)
    {
        NSLog(@"I have %d hour(s) left to drive.", x);
    }
    
//  5.  Perform a nested loop printin out values to the console
    for (int z=10; z > 0; z--)
    {
        NSLog(@"I have %d mile(s) left to drive.", z);
        for(float y=.2f; y < 1; y += 0.2f)
        {
            NSLog(@"A %.1f tenth of a mile has passed.", y);
        }
    }
        
//  6.  Perform a while loop that increments an int variable and outputs to the console.
    while (gasCurrent > 1){
        NSLog(@"I can drive a little further.");
        gasCurrent -= .5;
    }
    
    
    self.window = [[[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];
    // Override point for customization after application launch.
    self.window.backgroundColor = [UIColor whiteColor];
    [self.window makeKeyAndVisible];
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

@end
