//
//  DogClass.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "DogClass.h"

@implementation DogClass

@synthesize lbs, name;

-(void)setAttributes:(EDogType)type dogName:(NSString*)dogName pounds:(int)pounds
{
    lbs = pounds;
    name = dogName;
    dogType = type;
}

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"Name: %@, Pounds: %i", name, lbs];
    return words;
}



@end
