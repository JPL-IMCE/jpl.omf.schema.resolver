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

case class ReifiedRelationship private[impl] 
	(
	 override val uuid: resolver.api.taggedTypes.ReifiedRelationshipUUID,
	 override val source: resolver.api.Entity,
	 override val target: resolver.api.Entity,
	 override val isAsymmetric: scala.Boolean,
	 override val isEssential: scala.Boolean,
	 override val isFunctional: scala.Boolean,
	 override val isInverseEssential: scala.Boolean,
	 override val isInverseFunctional: scala.Boolean,
	 override val isIrreflexive: scala.Boolean,
	 override val isReflexive: scala.Boolean,
	 override val isSymmetric: scala.Boolean,
	 override val isTransitive: scala.Boolean,
	 override val name: gov.nasa.jpl.imce.oml.tables.taggedTypes.LocalName
)
extends resolver.api.ReifiedRelationship
  with ConceptualRelationship
  with CharacterizedEntityRelationship
{

  override def relationSource
  ()
	  : resolver.api.Entity
	  = {
	    source
	  }

  override def relationTarget
  ()
	  : resolver.api.Entity
	  = {
	    target
	  }

  override def allNestedElements
  ()(implicit extent: resolver.api.Extent)
	  : scala.collection.immutable.Set[_ <: resolver.api.LogicalElement]
	  = {
	    
	    		scala.collection.immutable.Set[resolver.api.LogicalElement]() ++
	    		extent.forwardProperty.get(this) ++
	    		extent.inverseProperty.get(this)
	  }

  override def rootCharacterizedEntityRelationships
  ()(implicit extent: resolver.api.Extent)
	  : scala.collection.immutable.Set[_ <: resolver.api.CharacterizedEntityRelationship]
	  = {
	    scala.collection.immutable.Set[resolver.api.ReifiedRelationship](this)
	  }

  override def canEqual(that: scala.Any): scala.Boolean = that match {
	  case _: ReifiedRelationship => true
 	  case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, source, target, isAsymmetric, isEssential, isFunctional, isInverseEssential, isInverseFunctional, isIrreflexive, isReflexive, isSymmetric, isTransitive, name).##

  override def equals(other: scala.Any): scala.Boolean = other match {
    case that: ReifiedRelationship =>
      (that canEqual this) &&
      (this.uuid == that.uuid) &&
      (this.source == that.source) &&
      (this.target == that.target) &&
      (this.isAsymmetric == that.isAsymmetric) &&
      (this.isEssential == that.isEssential) &&
      (this.isFunctional == that.isFunctional) &&
      (this.isInverseEssential == that.isInverseEssential) &&
      (this.isInverseFunctional == that.isInverseFunctional) &&
      (this.isIrreflexive == that.isIrreflexive) &&
      (this.isReflexive == that.isReflexive) &&
      (this.isSymmetric == that.isSymmetric) &&
      (this.isTransitive == that.isTransitive) &&
      (this.name == that.name)

    case _ =>
      false
  }
}
