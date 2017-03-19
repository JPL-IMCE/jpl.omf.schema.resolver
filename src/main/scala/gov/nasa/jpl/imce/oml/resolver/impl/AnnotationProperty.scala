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
 override val iri: gov.nasa.jpl.imce.oml.tables.IRI,
 override val abbrevIRI: gov.nasa.jpl.imce.oml.tables.AbbrevIRI
)
extends resolver.api.AnnotationProperty
{
  def uuid
  ()
  : java.util.UUID
  = {
    com.fasterxml.uuid.Generators.nameBasedGenerator(com.fasterxml.uuid.impl.NameBasedGenerator.NAMESPACE_URL).generate(iri)
  }
  



  override val hashCode
  : scala.Int
  = (iri, abbrevIRI).##

  override def equals(other: scala.Any): scala.Boolean = other match {
	  case that: AnnotationProperty =>
	    (that canEqual this) &&
	    (this.iri == that.iri) &&
	    (this.abbrevIRI == that.abbrevIRI)

	  case _ =>
	    false
  }
}
