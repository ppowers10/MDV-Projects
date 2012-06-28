//
//  DogFactory.m
//  week1
//
//  Created by Patrick Powers on 6/27/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "DogFactory.h"
#import "DogClass.h"
#import "BoxerDog.h"
#import "MastiffDog.h"
#import "BeagleDog.h"

@implementation DogFactory


-(DogClass*)GetDog:(int)dogType;
{
    if (dogType == 0)
    {
        return [[BoxerDog alloc] init];
    }
    else if (dogType == 1)
    {
        return [[MastiffDog alloc] init];
    }
    else if (dogType == 2)
    {
        return [[BeagleDog alloc] init];
    }
    return nil;
}

@end
