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

case class ChainRule private[impl] 
	(
	 override val uuid: resolver.api.taggedTypes.ChainRuleUUID,
	 override val name: gov.nasa.jpl.imce.oml.tables.taggedTypes.LocalName,
	 override val head: resolver.api.RestrictableRelationship
)
extends resolver.api.ChainRule
  with Rule
{

  override def canEqual(that: scala.Any): scala.Boolean = that match {
	  case _: ChainRule => true
 	  case _ => false
  }

  override val hashCode
  : scala.Int
  = (uuid, name, head).##

  override def equals(other: scala.Any): scala.Boolean = other match {
    case that: ChainRule =>
      (that canEqual this) &&
      (this.uuid == that.uuid) &&
      (this.name == that.name) &&
      (this.head == that.head)

    case _ =>
      false
  }
}
