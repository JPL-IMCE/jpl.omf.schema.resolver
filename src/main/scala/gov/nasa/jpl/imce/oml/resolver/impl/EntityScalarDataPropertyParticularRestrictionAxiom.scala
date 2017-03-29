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

case class EntityScalarDataPropertyParticularRestrictionAxiom private[impl] 
(
 override val tbox: scala.Option[java.util.UUID] /* reference to a resolver.api.TerminologyBox */,
 override val restrictedEntity: resolver.api.Entity,
 override val scalarProperty: resolver.api.EntityScalarDataProperty,
 override val literalValue: gov.nasa.jpl.imce.oml.tables.LexicalValue
)
extends resolver.api.EntityScalarDataPropertyParticularRestrictionAxiom
  with EntityScalarDataPropertyRestrictionAxiom
{
  override def uuid
  (extent: resolver.api.Extent)
  : scala.Option[java.util.UUID]
  = {
    
    	for {
    	  u1 <- tbox
    	  u2 <- restrictedEntity.uuid(extent)
        	  u3 <- scalarProperty.uuid(extent)
    	} yield gov.nasa.jpl.imce.oml.uuid.OMLUUIDGenerator.derivedUUID(
    		"EntityScalarDataPropertyParticularRestrictionAxiom",
    	    "tbox"->u1,
    		"restrictedEntity"->u2,
    		"scalarProperty"->u3)
  }
  



  override def canEqual(that: scala.Any): scala.Boolean = that match {
  	case _: EntityScalarDataPropertyParticularRestrictionAxiom => true
  	case _ => false
  }

  override val hashCode
  : scala.Int
  = (tbox, restrictedEntity, scalarProperty, literalValue).##

  override def equals(other: scala.Any): scala.Boolean = other match {
	  case that: EntityScalarDataPropertyParticularRestrictionAxiom =>
	    (that canEqual this) &&
	    (this.tbox == that.tbox) &&
	    (this.restrictedEntity == that.restrictedEntity) &&
	    (this.scalarProperty == that.scalarProperty) &&
	    (this.literalValue == that.literalValue)

	  case _ =>
	    false
  }
}
