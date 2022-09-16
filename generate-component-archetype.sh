#!/usr/bin/env bash

function die() {
  echo "Error: $1"
  exit 1
}

prog=`basename "$0"`

project=""
entity=""
silverpeas=""
while [[ $# -gt 0 ]]; do
  key="$1"
  case $key in
    -h)
      echo "Usage: $prog [-p PROJECT_NAME] [-e ENTITY_NAME] [-s SILVERPEAS_VERSION] [-h]"
      echo "Generate the skeleton of a Silverpeas component project from the dedicated Maven"
      echo "archetype"
      echo ""
      echo "The generation is done in an interactive mode by default and thus some missing"
      echo "parameters will be asked if not set within the command line"
      echo ""
      echo "with:"
      echo "   -p PROJECT_NAME"
      echo "                   The name of the project starting with a lower case character. This"
      echo "                   name will be used as a Maven artifact id for the project"
      echo "   -e ENTITY_NAME"
      echo "                   The name of the main business entity class the component will manage."
      echo "                   This name will be also used as prefix in the name of others classes"
      echo "                   of objects dedicated to handle theses business entities: repository,"
      echo "                   web controller, REST-based web services, ..."
      echo "   -s SILVERPEAS_VERSION"
      echo "                   The version of the Silverpeas platform on which the project has to"
      echo "                   be built."
      echo "   -h"
      echo "                   Print usage and exit"
      exit 0
      ;;
    -p)
      project="$2"
      shift # past argument
      shift # past value
      ;;
    -e)
      entity="$2"
      shift # past argument
      shift # past value
      ;;
    -s)
      silverpeas="$2"
      shift # past argument
      shift # past value
      ;;
    *)
      die "Unknown option: $1"
      ;;
  esac
done

mvn archetype:generate -DarchetypeGroupId=org.silverpeas.archetypes \
                       -DarchetypeArtifactId=component-archetype \
                       -DarchetypeVersion=3.1 \
                       -DgroupId=org.silverpeas.components \
                       -DartifactId=$project \
                       -Dversion=$silverpeas \
                       -Dpackage=org.silverpeas.components.$project \
                       -DClassNamePrefix=$entity \
                       -DSilverpeasVersion=$silverpeas

