# Silverpeas Maven Archetypes
Project gathering the different Maven archetypes to generate the skeleton of a project for Silverpeas.

Currently, there is only one proposed archetype: _Silverpeas Component Archetype_ to generate the 
skeleton of a Silverpeas Component project. A Silverpeas Component is an application dedicated to
manage in a given way some kinds of contributions within Silverpeas.

The archetypes are for Silverpeas >= 6.3. They cannot work for older Silverpeas versions.

The project provides also for each archetype a shell script to generate the skeleton of a project
from the last version of the archetype.

For the integration tests, you have to download the Wildfly distribution prepared for such tests:
https://www.silverpeas.org/files/wildfly-26.1.1.Final.FOR-TESTS.zip. Don't forget to start Wildfly
with _standalone-full.xml_ as configuration file before running any integration tests.