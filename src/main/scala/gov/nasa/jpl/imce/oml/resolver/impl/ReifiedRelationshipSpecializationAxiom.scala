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

case class ReifiedRelationshipSpecializationAxiom private[impl] 
	(
	 override val uuid: resolver.api.taggedTypes.ReifiedRelationshipSpecializationAxiomUUID,
	 override val superRelationship: resolver.api.ReifiedRelationship,
	 override val subRelationship: resolver.api.ReifiedRelationship
)
extends resolver.api.ReifiedRelationshipSpecializationAxiom
  with SpecializationAxiom
{

  /*
   * Get the sub (child) entity
   */
  override def child
  ()
	  : resolver.api.Entity
	  = {
	    subRelationship
	  }

  /*
   * Get the super (parent) entity
   */
  override def parent
  ()
	  : resolver.api.Entity
	  = {
	    superRelationship
	  }

  override def canEqual(that: scala.Any): scala.Boolean = that match {
	  case _: ReifiedRelationshipSpecializationAxiom => true
 	  case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, superRelationship, subRelationship).##

  override def equals(other: scala.Any): scala.Boolean = other match {
    case that: ReifiedRelationshipSpecializationAxiom =>
      (that canEqual this) &&
      (this.uuid == that.uuid) &&
      (this.superRelationship == that.superRelationship) &&
      (this.subRelationship == that.subRelationship)

    case _ =>
      false
  }
}