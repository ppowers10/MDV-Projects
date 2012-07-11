//
//  BoxerDog.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "BoxerDog.h"
#import "DogClass.h"

@implementation BoxerDog

//init function for the BoxerDog subclass
-(id)init
{
    self = [super init];
    if (self != nil)
    {
         //set attributes for the BoxerDog Class
        lbs = 50;
        name = @"Suzie";
        dogType = 0;
        age = 6;
    }
    return self;
}

-(int)getAge
{
    return age;
}

//overrides the weight gain to 30% of the dog's weight compared to DogClass.m and 20%
-(int)gainWeight
{
    int newWeight = lbs + (.3*lbs);
    return newWeight;
}

@end
