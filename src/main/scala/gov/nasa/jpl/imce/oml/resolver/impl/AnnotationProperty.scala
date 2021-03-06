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

case class AnnotationProperty private[impl] 
	(
	 override val uuid: resolver.api.taggedTypes.AnnotationPropertyUUID,
	 override val iri: gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI,
	 override val abbrevIRI: gov.nasa.jpl.imce.oml.tables.taggedTypes.AbbrevIRI
)
extends resolver.api.AnnotationProperty
  with IntrinsicIdentityKind
  with NonLogicalElement
{

  def moduleContext
  ()(implicit extent: resolver.api.Extent)
	  : scala.Option[resolver.api.Module]
	  = {
	    extent.moduleOfAnnotationProperty.get(this)
	  }

  override def iri
  ()(implicit extent: resolver.api.Extent)
	  : scala.Option[gov.nasa.jpl.imce.oml.tables.taggedTypes.IRI]
	  = {
	    scala.Some(iri)
	  }

  override def canEqual(that: scala.Any): scala.Boolean = that match {
	  case _: AnnotationProperty => true
 	  case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, iri, abbrevIRI).##

  override def equals(other: scala.Any): scala.Boolean = other match {
    case that: AnnotationProperty =>
      (that canEqual this) &&
      (this.uuid == that.uuid) &&
      (this.iri == that.iri) &&
      (this.abbrevIRI == that.abbrevIRI)

    case _ =>
      false
  }
}
