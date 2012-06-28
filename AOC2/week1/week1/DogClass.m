//
//  DogClass.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "DogClass.h"

@implementation DogClass


-(id)init
{
    self = [super init];
    if (self != nil)
    {
    lbs = 0;
    name = @"name";
    dogType = 0;
    }
    return self;
}

-(int)getLbs
{
    return lbs;
}

-(NSString*)getName
{
    return name;
}

-(void)setLbs :(int)newLbs
{
    lbs = newLbs;
}

-(void)setName : (NSString*)newName
{
    name = newName; 
}

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"Name: %@, Pounds: %i", name, lbs];
    return words;
}



@end
