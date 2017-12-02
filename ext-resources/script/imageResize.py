import os, sys
from PIL import Image

size = 127, 127


def convert_from_dir(directory):
    for i, filename in enumerate(os.listdir(directory)):
        print(filename.lower())
        if filename.lower().endswith('.png') or filename.lower().endswith('.jpg'):
            if not os.path.exists('ext-resources/obj-dir'):
                    os.makedirs('ext-resources/obj-dir')
            outfile = 'ext-resources/obj-dir/%d.jpg' % i
            im = Image.open(directory + '/' + filename)
            im = im.convert('RGB')
            im.thumbnail(size)
            im.save(outfile, 'JPEG')


def png2jpg(image):
    im = image.convert('RGB')
    return im


if __name__ == '__main__':
    convert_from_dir(sys.argv[1])
    print("Successfully convert to 127 * 127 pixel jpg image")
