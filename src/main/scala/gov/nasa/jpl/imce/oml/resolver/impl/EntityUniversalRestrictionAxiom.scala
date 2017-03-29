/*
 * Copyright 2016 California Institute of Technology ("Caltech").
 * U.S. Government sponsorship acknowledged.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * License Terms
 */

package gov.nasa.jpl.imce.oml.resolver.impl

import gov.nasa.jpl.imce.oml._

case class EntityUniversalRestrictionAxiom private[impl] 
(
 override val tbox: scala.Option[java.util.UUID] /* reference to a resolver.api.TerminologyBox */,
 override val restrictedRelation: resolver.api.EntityRelationship,
 override val restrictedDomain: resolver.api.Entity,
 override val restrictedRange: resolver.api.Entity
)
extends resolver.api.EntityUniversalRestrictionAxiom
  with EntityRestrictionAxiom
{
  override def uuid
  (extent: resolver.api.Extent)
  : scala.Option[java.util.UUID]
  = {
    
    	for {
    	  u1 <- tbox
    	  u2 <- restrictedDomain.uuid(extent)
        	  u3 <- restrictedRelation.uuid(extent)
    	  u4 <- restrictedRange.uuid(extent)
    	} yield gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator.derivedUUID(
    		"EntityUniversalRestrictionAxiom",
    	    "tbox"->u1,
    		"restrictedDomain"->u2,
    		"restrictedRelation"->u3,
    		"restrictedRange"->u4)
  }
  



  override def canEqual(that: scala.Any): scala.Boolean = that match {
  	case _: EntityUniversalRestrictionAxiom => true
  	case _ => false
  }

  override val hashCode
  : scala.Int
  = (tbox, restrictedRelation, restrictedDomain, restrictedRange).##

  override def equals(other: scala.Any): scala.Boolean = other match {
	  case that: EntityUniversalRestrictionAxiom =>
	    (that canEqual this) &&
	    (this.tbox == that.tbox) &&
	    (this.restrictedRelation == that.restrictedRelation) &&
	    (this.restrictedDomain == that.restrictedDomain) &&
	    (this.restrictedRange == that.restrictedRange)

	  case _ =>
	    false
  }
}
