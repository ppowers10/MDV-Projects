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

-(id)init
{
    self = [super init];
    if (self != nil)
    {
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

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"%@ is huge. The dog weighs %d lbs.", name, lbs];
    return words;
}

@end
