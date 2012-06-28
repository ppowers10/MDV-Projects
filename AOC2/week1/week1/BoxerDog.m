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

-(id)init
{
    self = [super init];
    if (self != nil)
    {
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

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"Pounds: %i, Name: %@", lbs, name];
    return words;
}

@end
