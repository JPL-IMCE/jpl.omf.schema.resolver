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

case class DescriptionBoxRefinement private[impl] 
	(
	 override val uuid: resolver.api.taggedTypes.DescriptionBoxRefinementUUID,
	 override val refinedDescriptionBox: gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI
)
extends resolver.api.DescriptionBoxRefinement
  with DescriptionBoxRelationship
{

  def descriptionDomain
  ()(implicit extent: resolver.api.Extent)
	  : scala.Option[resolver.api.DescriptionBox]
	  = {
	    extent.descriptionBoxOfDescriptionBoxRefinement.get(this)
	  }

  def targetModule
  ()(implicit extent: resolver.api.Extent)
	  : gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI
	  = {
	    refinedDescriptionBox
	  }

  override def canEqual(that: scala.Any): scala.Boolean = that match {
	  case _: DescriptionBoxRefinement => true
 	  case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, refinedDescriptionBox).##

  override def equals(other: scala.Any): scala.Boolean = other match {
    case that: DescriptionBoxRefinement =>
      (that canEqual this) &&
      (this.uuid == that.uuid) &&
      (this.refinedDescriptionBox == that.refinedDescriptionBox)

    case _ =>
      false
  }
}
