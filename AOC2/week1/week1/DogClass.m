//
//  DogClass.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "DogClass.h"

@implementation DogClass

//create a base class init
-(id)init
{
    self = [super init];
    if (self != nil)
    {
    //set basic attributes
    lbs = 0;
    name = @"name";
    dogType = 0;
    }
    return self;
}

//getter function for Lbs
-(int)getLbs
{
    return lbs;
}

//getter function for name
-(NSString*)getName
{
    return name;
}

//setter function for Lbs
-(void)setLbs :(int)newLbs
{
    lbs = newLbs;
}

//setter function for name
-(void)setName : (NSString*)newName
{
    name = newName; 
}

//calculation method
-(int)gainWeight
{
    int newWeight = lbs + (.3*lbs);
    return newWeight;
}


@end
