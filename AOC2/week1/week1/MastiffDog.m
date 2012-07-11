//
//  MastiffDog.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "MastiffDog.h"
#import "DogClass.h"

@implementation MastiffDog

//init function for the MastiffDog subclass
-(id)init
{
    self = [super init];
    if (self != nil)
    {
         //set attributes for the MastiffDog Class
        lbs = 120;
        name = @"Boss";
        dogType = 2;
        ownerName = @"Chris";
    }
    return self;
}

-(NSString*)getOwnerName
{
    return ownerName;
}

//overrides the weight gain to 30% of the dog's weight compared to DogClass.m and 20%
-(int)gainWeight
{
    int newWeight = lbs + (.3*lbs);
    return newWeight;
}

@end
