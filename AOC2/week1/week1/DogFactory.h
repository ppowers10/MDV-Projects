//
//  DogFactory.h
//  week1
//
//  Created by Patrick Powers on 6/27/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "DogClass.h"

@interface DogFactory : NSObject

+(DogClass*)GetDog:(int)dogType;

@end
