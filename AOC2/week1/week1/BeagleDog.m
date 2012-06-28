//
//  BeagleDog.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "BeagleDog.h"
#import "DogClass.h"

@implementation BeagleDog

-(id)init
{
    self = [super init];
    if (self != nil)
    {
        lbs = 20;
        name = @"Aspen";
        dogType = 2;
        toys = 10; 
    }
    return self;
}

-(int)getToys
{
    return toys;
}

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"%@ is %dlbs", name, lbs];
    return words;
}

@end
