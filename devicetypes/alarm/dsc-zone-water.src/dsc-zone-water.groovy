/*
 *  DSC Zone Device
 *
 *  Author: Matt Martz <matt.martz@gmail.com>
 *  Date: 2014-04-28
 */

// for the UI
metadata {
  definition (name: "DSC Zone Water", namespace: "Alarm", author: "matt.martz@gmail.com") {
    // Change or define capabilities here as needed
    capability "Refresh"
    capability "Water Sensor"
    capability "Sensor"
    capability "Polling"

    // Add commands as needed
    command "zone"
  }

  simulator {
    // Nothing here, you could put some testing stuff here if you like
  }

  tiles (scale: 2){
    // Main Row
    standardTile("zone", "device.contact", width: 6, height: 4, canChangeBackground: true, canChangeIcon: true) {
      state "open",   label: 'Wet', icon: "st.alarm.water.wet",   backgroundColor: "#ffa81e"
      state "closed", label: 'Dry', icon: "st.alarm.water.dry", backgroundColor: "#79b821"
      state "alarm",  label: 'ALARM - WET', icon: "st.alarm.water.wet",   backgroundColor: "#ff0000"
    }

    // This tile will be the tile that is displayed on the Hub page.
    main "zone"

    // These tiles will be displayed when clicked on the device, in the order listed here.
    details(["zone"])
  }
}

// handle commands
def zone(String state) {
  // state will be a valid state for a zone (open, closed)
  // zone will be a number for the zone
  log.debug "Zone: ${state}"
  sendEvent (name: "contact", value: "${state}")
}

def poll() {
  log.debug "Executing 'poll'"
  // TODO: handle 'poll' command
  // On poll what should we do? nothing for now..
}

def refresh() {
  log.debug "Executing 'refresh' which is actually poll()"
  poll()
  // TODO: handle 'refresh' command
}