//
//  ViewController.m
//  week1
//
//  Created by Patrick Powers on 6/25/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "DogClass.h"
#import "BoxerDog.h"
#import "MastiffDog.h"
#import "BeagleDog.h"
#import "DogFactory.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    //Factory to create dogs
    DogFactory *dogFactory = [[DogFactory alloc] init];
    if (dogFactory != nil) {
        //create boxer
        DogClass *boxer = [dogFactory GetDog:0];
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"Name: %@, Pounds: %i", [boxer  getName], [boxer getLbs]];
        [self.view addSubview:textLabel];
        
        //create mastiff
        DogClass *mastiff = [dogFactory GetDog:1];
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 60, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"Name: %@, Pounds: %i", [mastiff getName], [mastiff getLbs]];
        [self.view addSubview:textLabel];
        
        //create beagle
        DogClass *beagle = [dogFactory GetDog:2];
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 120, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"Name: %@, Pounds: %i", [beagle  getName], [beagle getLbs]];
        [self.view addSubview:textLabel];
        
    }  
    
    //creating labels without factory with NSLog of calculation override
    BoxerDog *boxerDog = [[BoxerDog alloc] init];
    if (boxerDog != nil)
        {    
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 180, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"%@ is %d years old.", [boxerDog getName], [boxerDog getAge]];
        [self.view addSubview:textLabel];
         //add the calculation override through NSLog
        NSLog(@"The dog now weighs %i", [boxerDog gainWeight]);
    }
    
    MastiffDog *mastiffDog = [[MastiffDog alloc] init];
    if (mastiffDog != nil)
    {        
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 240, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"%@ is the owner of %@.", [mastiffDog getOwnerName], [mastiffDog  getName]];
        [self.view addSubview:textLabel];
         //add the calculation override through NSLog
        NSLog(@"The dog now weighs %i", [mastiffDog gainWeight]);
    }
    
    BeagleDog *beagleDog = [[BeagleDog alloc] init];
    if(beagleDog != nil)
    {
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 300, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"%@ has %d toys.", [beagleDog getName], [beagleDog  getToys]];
        [self.view addSubview:textLabel];
        //add the calculation override through NSLog
        NSLog(@"The dog now weighs %i", [beagleDog gainWeight]);
    }
        
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
