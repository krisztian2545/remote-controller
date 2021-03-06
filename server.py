from flask import Flask, json, request
import robot
import sys

api = Flask(__name__)


@api.route('/cursor-pos', methods=['POST'])
def cursor_pos():
    request_data = request.json
    robot.move_cursor_to(request_data['pos-x'], request_data['pos-y'])
    return ""


@api.route('/type-text', methods=['POST'])
def type_text():
    request_data = request.json
    robot.type_text(request_data['text'])
    return ""


@api.route('/mouse-button', methods=['POST'])
def mouse_button():
    request_data = request.json
    mouse_button = None

    robot.mouse_button(request_data['mouse-button'],
                       request_data['event-action-type'])
    return ""


if __name__ == '__main__':
    host = "192.168.100.10"

    if len(sys.argv) > 1:
        host = sys.argv[1]

    print(host)

    api.run(host=host, port=8080)
