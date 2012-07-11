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

//init function for the BeagleDog subclass
-(id)init
{
    self = [super init];
    if (self != nil)
    {
        //set attributes for the BeagleDog Class
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

//overrides the weight gain to 30% of the dog's weight compared to DogClass.m and 20%
-(int)gainWeight
{
    int newWeight = lbs + (.3*lbs);
    return newWeight;
}

@end
