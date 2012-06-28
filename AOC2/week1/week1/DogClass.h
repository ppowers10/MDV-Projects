//
//  DogClass.h
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef enum
{
    Boxer_Dog=0,
    Mastiff_Dog,
    Beagle_Dog
} EDogType;

@interface DogClass : NSObject
{
    EDogType dogType;
    int lbs;
    NSString *name;
}

-(int)getLbs;
-(NSString*)getName;
-(void)setLbs :(int)newLbs;
-(void)setName : (NSString*)newName;


-(NSString*)printLabel;



@end
