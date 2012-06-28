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
    BoxerDog *boxerDog = [[BoxerDog alloc] init];
    if (boxerDog !=nil)
    {
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"Name: %@, Pounds: %i", [boxerDog  getName], [boxerDog getLbs]];
        [self.view addSubview:textLabel];
        
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 180, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"%@ is %d years old.", [boxerDog  getName], [boxerDog getAge]];
        [self.view addSubview:textLabel];
    }
    
    MastiffDog *mastiffDog = [[MastiffDog alloc] init];
    if (mastiffDog != nil)
    {
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 60, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"Name: %@, Pounds: %i", [mastiffDog getName], [mastiffDog getLbs]];
        [self.view addSubview:textLabel];
        
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 240, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"%@ is the owner of %@.", [mastiffDog getOwnerName], [mastiffDog  getName]];
        [self.view addSubview:textLabel];
    }
    
    BeagleDog *beagleDog = [[BeagleDog alloc] init];
    if(beagleDog != nil)
    {
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 120, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"Name: %@, Pounds: %i", [beagleDog  getName], [beagleDog getLbs]];
        [self.view addSubview:textLabel];
        
        textLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 300, 320, 60)];
        textLabel.text = [NSString stringWithFormat:@"%@ has %d toys.", [beagleDog getName], [beagleDog  getToys]];
        [self.view addSubview:textLabel];
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
